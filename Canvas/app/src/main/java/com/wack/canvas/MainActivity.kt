package com.wack.canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wack.canvas.ui.theme.CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CanvasEx()
                }
            }
        }
    }
}

@Composable
fun CanvasEx() {
    Canvas(modifier = Modifier.size(50.dp)) {

        // `drawLine`을 사용. 파라미터로 색상, 시작(`Offset`)
        // 끝(`Offset` 타입)
        drawLine(Color.Blue, Offset(30f, 30f), Offset(50f, 50f))

        // `drawCircle`을 사용. 색상, 반지름, 중앙(`Offset`)
        drawCircle(Color.Magenta, 20f, Offset(100f, 30f))

        // `Icons.Filled.Send`를 `drawLine`으로 변경

        // ImageVector에서는 한붓 그리기 처럼 연속으로 그려짐
        // `moveTo`로 2.01f, 21.0f로 이동한 후 거기에서 23.0f, 12.0f로 선이 그어짐

        //        moveTo(2.01f, 21.0f)
        //        lineTo(23.0f, 12.0f)
        //        lineTo(2.01f, 3.0f)
        //        lineTo(2.0f, 10.0f)
        //        lineToRelative(15.0f, 2.0f)
        //        lineToRelative(-15.0f, 2.0f)
        //        close()

        drawLine(Color.Red, Offset(2.01f, 21.0f), Offset(23.0f, 12.0f))
        drawLine(Color.Red, Offset(23.0f, 12.0f), Offset(2.01f, 3.0f))
        drawLine(Color.Red, Offset(2.01f, 3.0f), Offset(2.0f, 10.0f))
        drawLine(Color.Red, Offset(2.0f, 10.0f), Offset(17.0f, 12.0f))
        drawLine(Color.Red, Offset(17.0f, 12.0f), Offset(2.0f, 14.0f))
        drawLine(Color.Red, Offset(2.0f, 14.0f), Offset(2.01f, 21.0f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CanvasTheme {
        CanvasEx()
    }
}