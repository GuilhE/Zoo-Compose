/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.WelcomeTheme

@Composable
fun Welcome(onEnter: () -> Unit) {
    WelcomeTheme {
        Surface(color = MaterialTheme.colors.background) {
            Box(Modifier.fillMaxSize()) {
                ConstraintLayout {
                    val (title, host, button) = createRefs()

                    Box(
                        Modifier
                            .fillMaxWidth()
                            .constrainAs(title) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                            .padding(20.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.lbl_welcome),
                            style = MaterialTheme.typography.h2,
                        )
                        Text(
                            text = stringResource(R.string.lbl_welcome_desc),
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(start = 50.dp, top = 65.dp)
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.welcome),
                        contentDescription = null,
                        Modifier
                            .fillMaxSize()
                            .constrainAs(host) {
                                centerTo(parent)
                            }
                    )
                    Button(
                        onClick = { onEnter.invoke() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 30.dp)
                            .constrainAs(button) {
                                bottom.linkTo(parent.bottom)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                    ) {
                        Text(
                            text = stringResource(R.string.btn_enter),
                            style = MaterialTheme.typography.button,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MockWelcome() {
    Welcome { }
}
