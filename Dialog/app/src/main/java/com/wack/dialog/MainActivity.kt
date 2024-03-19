package com.wack.dialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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
                    CustomDialog()
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

@Composable
fun CustomDialog() {
    var openDialog by remember { mutableStateOf(false) }
    var counter by remember { mutableStateOf(0) }

    Column {
        Button(onClick = {
            openDialog = true
        }) {
            Text("다이얼로그 열기")
        }
        Text("카운터: $counter")
    }

    if (openDialog) {
        Dialog(onDismissRequest = {
            openDialog = false
        }) {
            Surface {
                // Column 안에 Low를 만들어 Button을 수평 정렬
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("카운터를 조작해봅시다.")
                    Row(modifier = Modifier.align(Alignment.End)) {
                        Button(onClick = {
                            counter--
                            openDialog = false
                        }) {
                            Text("-1")
                        }
                        Button(onClick = {
                            counter++
                            openDialog = false
                        }) {
                            Text("+1")
                        }
                        Button(onClick = {
                            openDialog = false
                        }) {
                            Text("취소")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DialogTheme {
        CustomDialog()
    }
}