/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.work@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurivanets.sample.ui.basic

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.PagerSnapHelper
import com.arthurivanets.arvi.Config
import com.arthurivanets.arvi.ktx.defaultExoCache
import com.arthurivanets.arvi.util.misc.ExoPlayerUtils
import com.arthurivanets.arvi.utils.recyclerview.PreCacheLinearLayoutManager
import com.arthurivanets.arvi.widget.PlayableItemsContainer
import com.arthurivanets.sample.R
import com.arthurivanets.sample.adapters.basic.BasicVideoItemsRecyclerViewAdapter
import com.arthurivanets.sample.ui.base.BaseFragment
import com.arthurivanets.sample.util.markers.CanManagePlayback
import com.arthurivanets.sample.util.markers.HasTitle
import com.arthurivanets.sample.util.providers.VideoProvider
import kotlinx.android.synthetic.main.fragment_videos.*

class BasicVideosFragment : BaseFragment(), CanManagePlayback, HasTitle {


    private var autoplayMode = PlayableItemsContainer.AutoplayMode.ONE_AT_A_TIME


    companion object {

        const val TAG = "BasicVideosFragment"
        private const val EXTRA_AUTOPLAY_MODE = "autoplay_mode"

        @JvmStatic fun newInstance(autoplayMode : PlayableItemsContainer.AutoplayMode) : BasicVideosFragment {
            return BasicVideosFragment().apply {
                arguments = newBundleInstance(autoplayMode)
            }
        }

        @JvmStatic fun newBundleInstance(autoplayMode : PlayableItemsContainer.AutoplayMode) : Bundle {
            return bundleOf(EXTRA_AUTOPLAY_MODE to autoplayMode)
        }

    }


    override fun fetchExtras(extras : Bundle) {
        super.fetchExtras(extras)

        autoplayMode = ((extras.getSerializable(EXTRA_AUTOPLAY_MODE) as PlayableItemsContainer.AutoplayMode?) ?: autoplayMode)
    }


    override fun init(savedInstanceState : Bundle?) {
        with(recyclerView) {
            setPlaybackTriggeringStates(
                PlayableItemsContainer.PlaybackTriggeringState.IDLING,
                PlayableItemsContainer.PlaybackTriggeringState.DRAGGING,
                PlayableItemsContainer.PlaybackTriggeringState.SETTLING
            )

            onFlingListener = null

            val pagerSnapHelper = PagerSnapHelper()
            pagerSnapHelper.attachToRecyclerView(this)

            autoplayMode = this@BasicVideosFragment.autoplayMode
            layoutManager = PreCacheLinearLayoutManager(requireContext()).also {
                it.isItemPrefetchEnabled = true
                it.initialPrefetchItemCount = 10
            }
            adapter = BasicVideoItemsRecyclerViewAdapter(
                context = requireContext(),
                items = VideoProvider.getVideos(count = 100, mute = false).toMutableList(),
                arviConfig = Config.Builder()
//                    .cache(requireContext().defaultExoCache())
                    .build()
            )
        }
    }


    override fun startPlayback() {
        recyclerView?.startPlayback()
    }


    override fun stopPlayback() {
        recyclerView?.stopPlayback()
    }


    override fun onResume() {
        super.onResume()

        if(userVisibleHint) {
            recyclerView.onResume()
        }
    }


    override fun onPause() {
        super.onPause()

        recyclerView.onPause()
    }


    override fun onBecameVisibleToUser() {
        super.onBecameVisibleToUser()

        if(isViewCreated) {
            recyclerView.onResume()
        }
    }


    override fun onBecameInvisibleToUser() {
        super.onBecameInvisibleToUser()

        if(isViewCreated) {
            recyclerView.onPause()
        }
    }


    override fun onRecycle() {
        super.onRecycle()

        recyclerView?.onDestroy()
    }


    override fun getLayoutId() : Int {
        return R.layout.fragment_videos
    }


    override fun getTitle(context : Context) : CharSequence {
        return when(autoplayMode) {
            PlayableItemsContainer.AutoplayMode.MULTIPLE_SIMULTANEOUSLY -> context.getString(R.string.title_videos_fragment_playback_multiple_simultaneously)
            else -> context.getString(R.string.title_videos_fragment_playback_one_at_a_time)
        }
    }


}