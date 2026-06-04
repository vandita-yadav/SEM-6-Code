package com.example.sem6
import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class MyJobService : JobService()
{

    override fun onStartJob(params: JobParameters?): Boolean {

        Log.d("JobScheduler", "Job Started")

        Thread {
            try {
                Thread.sleep(3000) // simulate background work
            } catch (e: Exception) {
                e.printStackTrace()
            }

            Log.d("JobScheduler", "Job Finished")

            jobFinished(params, false)
        }.start()

        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("JobScheduler", "Job Stopped")
        return true
    }
}