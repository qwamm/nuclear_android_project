package dznotificator.ui.screens

import androidx.lifecycle.ViewModel
import androidx.work.*
import dznotificator.workers.DzNotificator
import java.util.concurrent.TimeUnit

class MainViewModel: ViewModel() {
    private lateinit var workManager: WorkManager
    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()
    private val workName = "DzNotificator"

    fun setWorkManager(workManager: WorkManager) {
        this.workManager = workManager
    }

    fun runPeriodicWorkRequest() {

        //Note: repeatInterval must be >= MIN_PERIODIC_INTERVAL_MILLIS (15 minutes)
        val workRequest = PeriodicWorkRequestBuilder<DzNotificator>(
            repeatInterval = 7,
            TimeUnit.DAYS
        )
            .build()

        workManager.enqueueUniquePeriodicWork(
            workName,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequest)

    }


    fun cancelWorker() {
        workManager.cancelUniqueWork(workName)
    }
}