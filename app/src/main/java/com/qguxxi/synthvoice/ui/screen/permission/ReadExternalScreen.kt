package com.qguxxi.synthvoice.ui.screen.permission

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
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
import com.qguxxi.synthvoice.untils.permission.ReadExternalPermission

@Composable
fun ReadExternalScreen(
    navController: NavController,
    activity: Activity
) {
    val scheme = MaterialTheme.colorScheme
    Surface(
        modifier =  Modifier.fillMaxSize(),
        color = scheme.surface
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(3f))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.size(300.dp)
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.logo_icon) , contentDescription = null)
            }
            Spacer(modifier = Modifier.weight(5f))
            Text(
                text = "Interact Seamlessly with AI",
                style = figmaTypography.bodyMedium,
                color = scheme.onSurface
                )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Voice Activated and Ready",
                style = figmaTypography.labelLarge,
                color = scheme.onSurface
                )
            Spacer(modifier = Modifier.weight(5f))
            PermissionButton(
                permClick = { ReadExternalPermission.checkAndRequestReadPermission(navController = navController,activity) },
                idIcon = R.drawable.folder,
                idString = R.string.read_per,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(300.dp)
            )
            PrivacyPolicy(
                privacyOnClick = { /*TODO*/ },
                termServiceOnClick = { /*TODO*/ },
                stringIdRes = R.string.camera_per,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun ReadExternalScreenPreview() {
    ReadExternalScreen(navController = rememberNavController(), activity = MainActivity())
}