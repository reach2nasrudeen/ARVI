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

package com.arthurivanets.sample.util.providers

import android.net.Uri
import com.arthurivanets.sample.model.Video
import com.arthurivanets.sample.util.misc.randomPositiveInt

object VideoProvider {


    private val VIDEO_URLS = arrayListOf(
       /* "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"*/

        "https://dev.meeket.vn/api/v1.0/video/16829591816196537-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16829591015183925-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16823992138521700-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16823274487345152-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16821034188180586-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820828512659288-video1682082850.1391711.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820826657269823-video1682082665.305445.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820807637499229-video1682080762.80659.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820803679741322-video1682080366.976077.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820800102269085-video1682080008.9735951.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820793574738801-video1682079356.921485.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820665578260339-compress.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820592231993397-video1682059222.6213942.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820588787760196-video1682058874.1246629.mp4",
        "https://dev.meeket.vn/api/v1.0/video/16820588393011583-video1682058839.0084538.mp4",



        "https://dev.meeket.vn/api/v1.0/video/16835373347927682-video1683537330.603602.mp4",
"https://dev.meeket.vn/api/v1.0/video/16833780763920026-video1683378069.8948488.mp4",
"https://dev.meeket.vn/api/v1.0/video/16833780066173917-video1683377997.7792358.mp4",

    )

    private val vv = arrayListOf<String>(

        "https://dev.meeket.vn/api/v1.0/video/16835373347927682-video1683537330.603602.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833780763920026-video1683378069.8948488.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833780066173917-video1683377997.7792358.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833775259722732-video1683377519.783455.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833774259345001-video1683377419.89082.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833772918131447-video1683377283.332951.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833771470530447-video1683377136.517422.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833770061642747-video1683377002.968472.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833767955370063-video1683376791.498695.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833766766033462-video1683376672.2390962.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833764938207826-video1683376489.848236.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833761658058371-video1683376162.192336.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833759808719187-video1683375968.908928.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833660655132014-video1683366062.954976.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16833655746274205-video1683365568.6744618.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16832842940410273-video1683284286.412445.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16832841351413870-video1683284130.779738.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16832839925921035-video1683283988.826648.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16832821354455582-video1683282133.047339.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831804952389804-video1683180493.643342.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831802333969285-video1683180232.919483.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831801769217235-video1683180175.987589.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831800112547301-video1683180010.096225.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831783237482280-video1683178323.293854.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831777069538908-video1683177705.3809881.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831770505192991-video1683177049.843401.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16831102236265514-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830898026391237-video1683089802.230433.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830897263869480-video1683089726.150357.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830889286423798-video1683088927.972328.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830887786826756-video1683088777.521208.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830869879379422-video1683086987.1479049.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830869329513284-video1683086932.266862.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830207975242059-video1683020794.1130419.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830196064680158-video1683019598.210115.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830193514090592-video1683019345.8280358.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830119729287834-video1683011969.8154268.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16830119043023274-video1683011903.5904799.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16829591816196537-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16829591015183925-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16824053156713115-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16824048513439431-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823992138521700-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823331026752123-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823316095296369-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823314764801883-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823274487345152-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16823146203011151-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16821034188180586-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820828512659288-video1682082850.1391711.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820826657269823-video1682082665.305445.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820807637499229-video1682080762.80659.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820803679741322-video1682080366.976077.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820800102269085-video1682080008.9735951.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820793574738801-video1682079356.921485.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820665578260339-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820592231993397-video1682059222.6213942.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820588787760196-video1682058874.1246629.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820588393011583-video1682058839.0084538.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16820551712699213-video1682055170.362145.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819865663575312-video1681986566.082052.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819832991752975-video1681983298.413857.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819756260253441-video1681975625.3241282.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819743969639359-video1681974396.327066.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819725179793992-video1681972516.634824.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819678665169012-video1681967866.1240559.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16819671909303407-video1681967187.8258672.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817983626483935-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817974840673994-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817963896354489-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817959891833647-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817958486771625-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817957549464348-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817954419954256-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817947404752119-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817941051554924-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817926906108135-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817921282879395-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817312581357445-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16817158575807533-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815499579040534-video1681549957.6385841.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815496629478028-video1681549653.672926.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815487716350940-video1681548770.8135881.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815485610114677-video1681548560.48776.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815302056722954-video1681530204.1584458.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815299762867862-video1681529974.597584.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16815297971055265-video1681529795.789013.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16813687375449448-video1681368730.7205691.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16813685410480691-video1681368535.752501.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16813684052470361-video1681368404.209763.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16813681035719941-video1681368103.091373.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16813672737878306-video1681367271.6273.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812896453141812-video1681289645.165205.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812842455358145-video1681284244.64286.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812826715468269-video1681282671.167278.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812825845020321-video1681282583.595433.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812823590088513-video1681282357.938216.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812814894660275-video1681281489.218876.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812112038407066-compress.mp4",
    "https://dev.meeket.vn/api/v1.0/video/16812106920756198-compress.mp4",
    )


    @JvmStatic fun getVideos(count : Int, mute : Boolean = true) : List<Video> {
        val items = ArrayList<Video>()

        /*for(i in 0 until count) {
            val index = (i % VIDEO_URLS.size)
            val url = VIDEO_URLS[index]

            items.add(Video(
                id = randomPositiveInt(),
                title = (Uri.parse(url).lastPathSegment ?: ""),
                videoUrl = url,
                isMuted = mute
            ))
        }*/

        vv.forEach { url ->
            items.add(Video(
                id = randomPositiveInt(),
                title = (Uri.parse(url).lastPathSegment ?: ""),
                videoUrl = url,
                isMuted = mute
            ))
        }


        return items
    }


}