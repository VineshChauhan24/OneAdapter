package com.idanatz.oneadapter.tests.modules.empiness

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.idanatz.oneadapter.external.holders.EmptyIndicator
import com.idanatz.oneadapter.external.interfaces.Item
import com.idanatz.oneadapter.external.modules.EmptinessModule
import com.idanatz.oneadapter.helpers.BaseTest
import com.idanatz.oneadapter.internal.holders.Metadata
import com.idanatz.oneadapter.internal.holders.ViewBinder
import com.idanatz.oneadapter.test.R
import org.amshove.kluent.shouldEqualTo
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WhenAdapterEmptyOnBindShouldBeCalledOnce : BaseTest() {

    private var onBindCalls = 0

    @Test
    fun test() {
        configure {
            actOnActivity {
                oneAdapter.attachEmptinessModule(TestEmptinessModule())
            }
            untilAsserted {
                onBindCalls shouldEqualTo 1
            }
        }
    }

    inner class TestEmptinessModule : EmptinessModule() {
        override fun provideModuleConfig() = modulesGenerator.generateValidEmptinessModuleConfig()
        override fun onBind(item: Item<EmptyIndicator>, viewBinder: ViewBinder) {
            onBindCalls++
        }
    }
}