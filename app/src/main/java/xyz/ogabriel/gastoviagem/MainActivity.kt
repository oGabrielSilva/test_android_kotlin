package xyz.ogabriel.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import xyz.ogabriel.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalc.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calc) calc()
    }

    private fun isDataValid(): Boolean {
        return (binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calc() {
        //Toast.makeText(this, "Button clicado", Toast.LENGTH_SHORT).show()
        if (!isDataValid())
            return Toast.makeText(this, getString(R.string.validation_all_fields), Toast.LENGTH_SHORT).show()
        val distance = binding.editDistance.text.toString().toFloat()
        val price = binding.editPrice.text.toString().toFloat()
        val autonomy = binding.editAutonomy.text.toString().toFloat()

        val total = (distance * price) / autonomy
        binding.textValue.text = "R$ ${"%.2f".format(total)}"

    }
}