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
package com.github.guilhe.zoocompose.presentation.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.github.guilhe.zoocompose.data.model.Animal
import com.github.guilhe.zoocompose.presentation.navigation.Screen
import com.github.guilhe.zoocompose.presentation.ui.detail.AnimalDetailScreen
import com.github.guilhe.zoocompose.presentation.ui.list.AnimalScreen
import com.github.guilhe.zoocompose.presentation.ui.welcome.WelcomeScreen

@Composable
fun ZooWithNavHostMultiComposable(viewModel: MainViewModel) {
    val controller = rememberNavController()
    BackHandler(onBack = { controller.navigateUp() })

    NavHost(navController = controller, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen {
                controller.popBackStack()
                controller.navigate(Screen.List.route)
            }
        }
        composable(route = Screen.List.route) { AnimalScreen(viewModel) { controller.navigate("${Screen.Detail.route}/${it.name}") } }
        composable(
            route = Screen.Detail.routeWithArgument,
            arguments = listOf(navArgument(Screen.Detail.argument0) { type = NavType.IntType })
        ) {
            it.arguments?.getInt(Screen.Detail.argument0)?.let { id ->
                viewModel.animalList.firstOrNull { item -> item.name == id }?.let { animal ->
                    AnimalDetailScreen(animal, onBack = { controller.navigateUp() })
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun ZooWithNavHostSingleComposable(viewModel: MainViewModel) {
    val controller = rememberNavController()
    var welcomeVisible by rememberSaveable { mutableStateOf(true) }
    var detailVisible by rememberSaveable { mutableStateOf(false) }
    var animal by rememberSaveable { mutableStateOf<Animal?>(null) }

    BackHandler(
        onBack = {
            if (detailVisible) {
                detailVisible = false
            } else {
                controller.navigateUp()
            }
        }
    )

    NavHost(navController = controller, startDestination = Screen.Welcome.route) {
        composable(route = Screen.Welcome.route) {
            AnimatedVisibility(visible = true, initiallyVisible = false, enter = fadeIn(), exit = fadeOut()) {
                AnimalScreen(viewModel) {
                    animal = it
                    detailVisible = true
                }
            }

            AnimatedVisibility(visible = welcomeVisible, enter = fadeIn(), exit = fadeOut()) {
                WelcomeScreen {
                    welcomeVisible = false
                }
            }

            AnimatedVisibility(
                visible = detailVisible, initiallyVisible = !detailVisible,
                enter = slideInHorizontally(
                    initialOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 200)
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { fullWidth -> fullWidth },
                    animationSpec = tween(durationMillis = 200)
                )
            ) {
                animal?.let {
                    AnimalDetailScreen(it) {
                        detailVisible = false
                    }
                }
            }
        }
    }
}

@Composable
fun ZooWithOutNavHost(onEnter: () -> Unit) {
    WelcomeScreen(onEnter)
}
