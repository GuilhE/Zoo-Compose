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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import com.github.guilhe.zoocompose.presentation.theme.AppTheme
import com.github.guilhe.zoocompose.presentation.transition.ActivityTransitionBehavior
import com.github.guilhe.zoocompose.presentation.transition.SlideHorizontalOnTopTransition
import com.github.guilhe.zoocompose.presentation.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val transitionBehavior: ActivityTransitionBehavior by lazy { SlideHorizontalOnTopTransition(this) }
    private val viewModel: MainViewModel by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        transitionBehavior.onCreateTransitions(window)
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val key = intent.getIntExtra(EXTRA_FOR_ANIMAL_ID, -1)
                viewModel.animalList.firstOrNull { item -> item.name == key }?.let { animal ->
                    AnimalDetailScreen(animal, onBack = { onBackPressed() })
                }
            }
        }
    }

    override fun finish() = super.finish().also { transitionBehavior.onFinishTransitions() }

    companion object {
        const val EXTRA_FOR_ANIMAL_ID = "EXTRA_FOR_ANIMAL_ID"
    }
}
