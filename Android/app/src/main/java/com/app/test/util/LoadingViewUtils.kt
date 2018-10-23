package guru.jini.ilf.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar

/**
 * Created by nimisha-jiniguru on 26/12/17.
 */
class LoadingViewUtils {

    companion object {
        var dialog: Dialog? = null

        fun showLoading(context: Context) {
            try {
                if (dialog != null) {
                    if (dialog!!.isShowing) {
                        dialog?.dismiss()
                    }

                }
                dialog = Dialog(context)

                dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog?.setCancelable(false)
                var sp = ProgressBar(context)
                dialog?.setContentView(sp)
                dialog?.window?.setGravity(Gravity.CENTER)

                var lp = WindowManager.LayoutParams()
                lp.copyFrom(dialog?.window?.attributes)

                dialog?.window?.attributes = lp

                var draw = ColorDrawable(Color.TRANSPARENT)
                dialog?.window?.setBackgroundDrawable(draw)
                dialog?.show()

            }catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun hideLoading() {
            try {
                dialog?.dismiss()

            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}