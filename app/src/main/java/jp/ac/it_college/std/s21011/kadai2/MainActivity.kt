package jp.ac.it_college.std.s21011.kadai2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.ac.it_college.std.s21011.kadai2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1

    private val quizData = mutableListOf(
        mutableListOf("北海道", "札幌市", "長崎市", "福島市", "前橋市"),
        mutableListOf("青森県", "青森市", "広島市", "甲府市", "岡山市"),
        mutableListOf("岩手県", "盛岡市", "大分市", "秋田市", "福岡市"),
        mutableListOf("宮城県", "仙台市", "水戸市", "岐阜市", "福井市"),
        mutableListOf("秋田県", "秋田市", "横浜市", "鳥取市", "仙台市"),
        mutableListOf("山形県", "山形市", "青森市", "山口市", "奈良市"),
        mutableListOf("福島県", "福島市", "盛岡市", "新宿区", "京都市"),
        mutableListOf("茨城県", "水戸市", "金沢市", "名古屋市", "奈良市"),
        mutableListOf("栃木県", "宇都宮市", "札幌市", "岡山市", "奈良市"),
        mutableListOf("群馬県", "前橋市", "福岡市", "松江市", "福井市")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showNextQuiz() {

    }

    fun checkAnswer(view: View) {

    }

    fun checkQuizCount() {

    }
}