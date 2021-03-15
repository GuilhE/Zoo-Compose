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
package com.github.guilhe.zoocompose.presentation.ui.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.github.guilhe.zoocompose.R
import com.github.guilhe.zoocompose.data.model.Animal
import com.github.guilhe.zoocompose.presentation.theme.AppTheme
import com.github.guilhe.zoocompose.presentation.theme.ButtonTheme
import com.github.guilhe.zoocompose.presentation.theme.OverlayTheme
import kotlinx.coroutines.launch
import kotlin.math.min

@Composable
fun AnimalDetailScreen(animal: Animal, onBack: () -> Unit) {
    AnimalDetail(animal, onBack)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AnimalDetail(animal: Animal, onBack: () -> Unit) {
    val scrollState = rememberScrollState()
    val imageAlpha = min(1f, 1 - (scrollState.value / 600f))
    val barBgAlpha = min(1f, (scrollState.value / 800f))
    val barTitleAlpha = min(1f, (scrollState.value / 1000f))

    var adopted by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Surface(color = MaterialTheme.colors.surface) {
        Scaffold(
            floatingActionButton = {
                AdoptFloatingActionButton(
                    extended = !adopted,
                    onClick = {
                        scope.launch {
                            if (!adopted) {
                                adopted = true
                            }
                        }
                    }
                )
            }
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.surface)
            ) {
                ConstraintLayout {
                    val (image, description) = createRefs()
                    Image(
                        painter = painterResource(animal.image),
                        contentDescription = stringResource(animal.name),
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp, bottom = 20.dp)
                            .graphicsLayer {
                                alpha = imageAlpha
                                translationY = -scrollState.value * 0.1f
                            }
                            .constrainAs(image) {
                                centerHorizontallyTo(parent)
                                top.linkTo(parent.top)
                            }
                    )
                    Column(
                        Modifier
                            .verticalScroll(scrollState)
                            .padding(top = 270.dp)
                            .constrainAs(description) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    ) {
                        Text(
                            stringResource(animal.name),
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp)
                        )
                        Text(
                            stringResource(animal.description),
                            textAlign = TextAlign.Justify,
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Light,
                            lineHeight = 27.sp,
                            modifier = Modifier.padding(
                                start = 20.dp,
                                top = 5.dp,
                                end = 20.dp,
                                bottom = 100.dp
                            )
                        )
                    }
                    Confetti(adopted)
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .shadow(elevation = barTitleAlpha.dp)
                    ) {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .graphicsLayer { alpha = barBgAlpha }
                                .background(MaterialTheme.colors.surface)
                        ) {
                            Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    stringResource(animal.name),
                                    textAlign = TextAlign.Justify,
                                    style = MaterialTheme.typography.h5,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .padding(start = 50.dp)
                                        .graphicsLayer { alpha = barTitleAlpha }
                                        .clearAndSetSemantics { }
                                )
                            }
                        }
                        IconButton(modifier = Modifier.fillMaxHeight(), onClick = { onBack.invoke() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.acc_navigation_back),
                                tint = MaterialTheme.colors.onSurface
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun AdoptFloatingActionButton(extended: Boolean, onClick: () -> Unit) {
    ButtonTheme {
        FloatingActionButton(
            onClick = onClick,
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        ) {
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Image(
                    painter = painterResource(if (extended) R.drawable.ic_heart else R.drawable.ic_heart_full),
                    contentDescription = stringResource(if (extended) R.string.acc_adopt_fab else R.string.acc_adopt_success)
                )
                AnimatedVisibility(visible = extended) {
                    Text(
                        text = stringResource(R.string.btn_adopt),
                        modifier = Modifier
                            .padding(start = 8.dp, top = 3.dp)
                            .clearAndSetSemantics { }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun Confetti(show: Boolean) {
    // using a repeatable animationSpec with Reverse would reset to final state after animation was complete...
    val fadeIn: Float by animateFloatAsState(
        targetValue = if (show) 1f else 0f,
        animationSpec = tween(durationMillis = 2000, easing = FastOutSlowInEasing)
    )
    val fadeOut: Float by animateFloatAsState(
        targetValue = if (show) -1f else 0f,
        animationSpec = tween(durationMillis = 2000, delayMillis = 2000, easing = FastOutSlowInEasing)
    )
    val verticalVal: Dp by animateDpAsState(
        targetValue = if (show) 30.dp else 0.dp,
        animationSpec = tween(durationMillis = 1500, delayMillis = 250, easing = FastOutSlowInEasing)
    )
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer { alpha = fadeIn + fadeOut }
    ) {
        val (overlay, host, confetti) = createRefs()
        OverlayTheme {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.primary)
                    .constrainAs(overlay) {
                        centerTo(parent)
                    }
            ) {}
        }
        Image(
            painter = painterResource(R.drawable.host),
            contentDescription = null,
            modifier = Modifier.constrainAs(host) {
                bottom.linkTo(parent.bottom)
            }
        )
        Image(
            painter = painterResource(R.drawable.confetti),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(confetti) {
                    start.linkTo(host.start)
                    bottom.linkTo(host.bottom)
                }
                .padding(start = 70.dp, bottom = 120.dp + verticalVal)
                .rotate(20f)
        )
    }
}

@Composable
@Preview
private fun MockDetail() {
    AppTheme {
        AnimalDetail(animalMock) {}
    }
}

@Composable
@Preview
private fun MockDarkDetail() {
    AppTheme(darkTheme = true) {
        AnimalDetail(animalMock) {}
    }
}

@Composable
@Preview
private fun MockConfetti() {
    AppTheme {
        Confetti(true)
    }
}

private val animalMock = Animal(R.string.crocodile_name, R.drawable.crocodile, R.string.crocodile_desc)
