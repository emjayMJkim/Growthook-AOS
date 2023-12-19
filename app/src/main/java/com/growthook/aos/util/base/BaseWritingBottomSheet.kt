package com.growthook.aos.util.base

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.growthook.aos.util.writingbottomsheet.LargeWritingBottomSheet
import com.growthook.aos.util.writingbottomsheet.SmallWritingBottomSheet

abstract class BaseWritingBottomSheet : BottomSheetDialogFragment() {

    var _binding: ViewBinding? = null

    protected lateinit var clickSaveBtn: (String) -> Unit
    protected lateinit var clickNoWritingBtn: () -> Unit
    protected var title: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickSave { clickSaveBtn; dismiss() }
        setClickNoWrite { clickNoWritingBtn(); dismiss() }
        setTitle()
    }

    abstract fun setClickSave(action: (String) -> Unit)
    abstract fun setTitle()

    abstract fun setClickNoWrite(action: () -> Unit)

    class Builder {

        fun build(
            type: WritingType,
            title: String,
            clickSaveBtn: (String) -> Unit,
            clickNoWritingBtn: () -> Unit,
        ): BaseWritingBottomSheet {
            return type.getInstance().apply {
                this.title = title
                this.clickSaveBtn = clickSaveBtn
                this.clickNoWritingBtn = clickNoWritingBtn
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    enum class WritingType {
        SMALL {
            override fun getInstance(): BaseWritingBottomSheet = SmallWritingBottomSheet()
        },
        LARGE {
            override fun getInstance(): BaseWritingBottomSheet = LargeWritingBottomSheet()
        }, ;

        abstract fun getInstance(): BaseWritingBottomSheet
    }
}
