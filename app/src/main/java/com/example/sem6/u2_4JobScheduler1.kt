package com.example.sem6
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

class u2_4JobScheduler1 : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent { JobSchedulerScreen() }
    }
}

@Composable
fun JobSchedulerScreen()
{
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(all = 16.dp), verticalArrangement = Arrangement.Center)
    {
        Button(onClick = {scheduleJob(context)})
        {
            Text("Schedule Job")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick={cancelJob(context)})
        {
            Text("Cancel Job")
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

fun scheduleJob(context: Context)
{
    val componentName = ComponentName(context, MyJobService::class.java)
    val jobinfo = JobInfo.Builder(1, componentName)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        .setRequiresCharging(false)
        .setMinimumLatency(5000)
        .setPersisted(false)
        .build()
    val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

    jobScheduler.schedule(jobinfo)
    Toast.makeText(context, "Job Scheduled", Toast.LENGTH_SHORT).show()
}

fun cancelJob(context: Context)
{
    val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
    jobScheduler.cancel(1)
    Toast.makeText(context, "Job cancelled!", Toast.LENGTH_SHORT).show()
}
