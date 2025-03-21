package de.berlindroid.zeapp.zeui.zepages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.berlindroid.zeapp.PAGE_HEIGHT
import de.berlindroid.zeapp.PAGE_WIDTH
import de.berlindroid.zeapp.R
import de.berlindroid.zeapp.zeui.rememberBarcodeBitmapPainter

/**
 * A composable that represents a badge, to be rendered as a bitmap.
 */
@Composable
@Preview
fun BarCodePage(
    title: String = "Hello, my github profile is",
    url: String = "https://github.com/gdg-berlin-android",
) {
    Column(
        modifier = Modifier
            .background(
                color = Color.White,
            )
            .size(
                width = with(LocalDensity.current) { PAGE_WIDTH.toDp() },
                height = with(LocalDensity.current) { PAGE_HEIGHT.toDp() },
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF801000)),
            fontFamily = FontFamily.Cursive,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            maxLines = 1,
            text = title,
        )

        val painter =
            if (url.isEmpty()) {
                painterResource(id = R.drawable.page_telekom)
            } else {
                rememberBarcodeBitmapPainter(url)
            }
        Image(
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(40.dp),
        )
    }
}
