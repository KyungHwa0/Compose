package com.wack.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wack.dialog.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DialogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DialogEx()
                }
            }
        }
    }
}

@Composable
fun DialogEx() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = { openDialog = !openDialog }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        AlertDialog(onDismissRequest = {
            //다이얼로그를 끌 수 있게 합니다.
            openDialog = false
        }, confirmButton = {
            // "더하기" 버튼을 만들고 `counter`를 증가
            Button(
                onClick = {
                    counter++
                    openDialog = false
                }
            ) {
                Text("더하기")
            }
        }, dismissButton = {
            //"취소" 버튼
            Button(
                onClick = {
                    openDialog = false
                }
            ) {
                Text(text = "취소")
            }
        }, title = {
            //타이틀 "더하기"
                   Text(text = "더하기")
        }, text = {
            // 설명 문구 출력
            Text(text = "1을 더하겟습니까?")
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogTheme {
        DialogEx()
    }
}