package com.qguxxi.synthvoice.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.qguxxi.synthvoice.MainActivity
import com.qguxxi.synthvoice.R
import com.qguxxi.synthvoice.ui.components.button.PermissionButton
import com.qguxxi.synthvoice.ui.components.under.PrivacyPolicy
import com.qguxxi.synthvoice.ui.theme.figmaTypography
import com.qguxxi.synthvoice.untils.permission.CameraPermission

@Composable
fun CameraPerScreen(navController: NavController,activity: Activity,modifier: Modifier = Modifier) {
    Surface(
        modifier =  modifier.fillMaxSize()
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.gradient))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Box(
                modifier = Modifier.size(300.dp)
            ) {
                LottieAnimation(
                    composition = composition,
                    speed = 2.5f,
                    iterations = LottieConstants.IterateForever
                )
            }
            Spacer(modifier = modifier.weight(5f))
            Text(text = "Interact Seamlessly with AI", style = figmaTypography.bodyMedium)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Voice Activated and Ready", style = figmaTypography.labelLarge)
            Spacer(modifier = modifier.weight(5f))
            PermissionButton(
                permClick = { CameraPermission.checkAndRequestCameraPermission(navController = navController, activity = activity) },
                idIcon = R.drawable.camera,
                idString = R.string.camera,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 16.dp)
                )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.camera_per,
                modifier = modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun CameraPerScreenPreview() {
    CameraPerScreen(navController = rememberNavController(), activity = MainActivity())
}