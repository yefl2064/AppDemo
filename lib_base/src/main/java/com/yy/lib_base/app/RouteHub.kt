package com.yy.lib_base.app

interface RouteHub{
    companion object {

        const val SERVICE = "/service"


        const val module_main = "/app_main"
        const val M_MAIN = "$module_main/MainActivity"


        const val module_a = "/app_a"
        const val A_MAIN = "$module_a/AMainActivity"
        const val A_ROOM = "$module_a/RoomActivity"
        const val A_WORK = "$module_a/WorkActivity"

        const val A_Service = "$SERVICE/AServiceImpl"



        const val module_b = "/app_b"
        const val B_MAIN = "$module_b/BMainActivity"




    }


    
}