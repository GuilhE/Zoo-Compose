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
package com.github.guilhe.zoocompose.presentation.transition

import android.transition.AutoTransition
import android.view.Window
import androidx.activity.ComponentActivity

class SlideHorizontalOnTopTransition(private val owner: ComponentActivity) : ActivityTransitionBehavior {

    override var activityTransition: ActivityTransition = SlideHorizontalOnTopActivityTransition()

    override fun onCreateTransitions(window: Window) {
        // Shared transitions purpose, disable the 'blink'">
        val transition = AutoTransition()
        transition.excludeTarget(android.R.id.statusBarBackground, true)
        transition.excludeTarget(android.R.id.navigationBarBackground, true)
        window.enterTransition = transition
        window.exitTransition = transition

        owner.overridePendingTransition(
            activityTransition.getStartEnterAnim(),
            activityTransition.getStartExitAnim()
        )
    }

    override fun onFinishTransitions() {
        owner.overridePendingTransition(
            activityTransition.getFinishEnterAnim(),
            activityTransition.getFinishExitAnim()
        )
    }
}
