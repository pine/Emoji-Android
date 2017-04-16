package moe.pine.emoji.example.slack

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import moe.pine.emoji.lib.slack.RegisterResult

/**
 * AddEmojiTask
 * Created by pine on Apr 17, 2017.
 */
class AddEmojiTask(
        val context: Context
) : AsyncTask<AddEmojiTask.Arguments, Unit, RegisterResult>() {
    data class Arguments(
            val team: String,
            val username: String,
            val password: String,
            val emojiName: String,
            val emojiUrl: String
    )

    lateinit var dialog: ProgressDialog

    override fun onPreExecute() {
        super.onPreExecute()
        this.dialog = ProgressDialog(this.context).also {
            it.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            it.isIndeterminate = true
            it.setTitle("Loading ...")
            it.setMessage("Try to register")
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.show()
        }
    }

    override fun doInBackground(vararg params: Arguments): RegisterResult {
        val param = params[0]

        return RegisterResult(true, "")
    }

    override fun onPostExecute(result: RegisterResult) {
        super.onPostExecute(result)
        this.dialog.dismiss()

        /*
        if (result) {
            AlertDialog.Builder(this.context)
                    .setTitle("Successful")
                    .setMessage("Register succeeded")
                    .setCancelable(false)
                    .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
                    .show()
        } else {
            AlertDialog.Builder(this.context)
                    .setTitle("Failure")
                    .setMessage("Login failed")
                    .setCancelable(false)
                    .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
                    .show()
        }
        */
    }
}