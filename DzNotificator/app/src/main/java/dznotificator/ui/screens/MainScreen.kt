package dznotificator.ui.screens

import android.Manifest
import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dznotificator.ui.permission.RuntimePermissionsDialog

@Composable
fun MainScreen(viewModel: MainViewModel) {

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        RuntimePermissionsDialog(
            Manifest.permission.POST_NOTIFICATIONS,
            onPermissionDenied = {},
            onPermissionGranted = {},
        )
    }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Button(onClick = {
            viewModel.runPeriodicWorkRequest()
        }) {
            Text("Включить уведомления о домашках")
        }


        Button(onClick = {
            viewModel.cancelWorker()
        }) {
            Text("Выключить уведомления")
        }
    }
}
