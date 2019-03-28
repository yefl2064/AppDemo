package com.yy.app_a.ui.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.blankj.utilcode.util.LogUtils


class Work1(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams){


    override fun doWork(): Result {
        Thread.sleep(10000)
        LogUtils.d("sleep 10000")
        return Result.success()
    }

}