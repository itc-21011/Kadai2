package jp.ac.it_college.std.s21011.kadai2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import jp.ac.it_college.std.s21011.kadai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private var QUIZ_COUNT = 10

    private val quizData = mutableListOf(
        mutableListOf("１＋１＝？", "２", "１", "０", "１０"),
        mutableListOf("１✕１＝？", "１", "２", "１０", "１００"),
        mutableListOf("物事に全力を尽くすこと。", "一生懸命", "一蓮托生", "悪戦苦闘", "意気投合"),
        mutableListOf("偶然の利益を、労せずに得ようとする欲心。", "射幸心", "慢心", "悪心", "以心伝心"),
        mutableListOf("裸子植物", "マツ", "たんぽぽ", "アサガオ", "さくら"),
        mutableListOf("１気圧 = ？ hPa", "１０１３", "１０００", "１００", "１１３"),
        mutableListOf("本能寺の変はいつ？", "１５８２年", "１６００年", "１１８５年", "１９７２年"),
        mutableListOf("日本の都道府県の数は？", "４７", "４６", "４８", "４５"),
        mutableListOf("English の日本語訳は？", "英語", "日本語", "中国語", "韓国語"),
        mutableListOf("Japan の日本語訳は？", "日本", "アメリカ", "ドイツ", "オーストラリア")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizData.shuffle()

        showNextQuiz()
    }

    fun showNextQuiz() {
        binding.countLabel.text = getString(R.string.count_label, quizCount)

        val quiz = quizData[0]

        binding.questionLabel.text = quiz[0]

        rightAnswer = quiz[1]

        quiz.removeAt(0)

        quiz.shuffle()

        binding.answerBtn1.text = quiz[0]
        binding.answerBtn2.text = quiz[1]
        binding.answerBtn3.text = quiz[2]
        binding.answerBtn4.text = quiz[3]

        quizData.removeAt(0)
    }

    fun checkAnswer(view: View) {
        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        val alertTitle: String
        if (btnText == rightAnswer) {
            alertTitle = "正解"
            rightAnswerCount++
        }else {
            alertTitle = "不正解"
        }

        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("答え：$rightAnswer")
            .setPositiveButton("OK") {dialogInterface, i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()
    }

    fun checkQuizCount() {
        if (quizCount == QUIZ_COUNT) {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)
        } else {
            quizCount++
            showNextQuiz()
        }
    }
}