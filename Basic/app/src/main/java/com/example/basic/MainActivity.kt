package com.example.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.basic.ui.theme.BasicTheme


// remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTheme {
                MyTextField3()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField1() {
    var textState by remember {
        mutableStateOf("Hello")
    }

    TextField(
        value = textState,
        onValueChange = {
            textState = it //변화되는 값
        },
        label = {
            Text(text = "입력 하는 곳")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField2() {
    var textState by remember {
        mutableStateOf("Hello")
    }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it //변화되는 값
        },
        label = {
            Text(text = "입력 하는 곳")
        }
    )
}

// TextField 부분에 입력하고
// 버튼을 클릭하면
// 밑에 Text 부분에 입력한 값 출력
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField3() {
    // 입력 받는 곳
    var textState by remember { mutableStateOf("") }

    // 출력 하는 곳
    var outputText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        // 세로 중앙 정렬
        verticalArrangement = Arrangement.Center,
        // 가로 중앙 정렬
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                outputText = textState
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "입력하기")
        }
        Text(
            text = "결과값 텍스트 : $outputText"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicTheme {
        MyTextField3()
    }
}
