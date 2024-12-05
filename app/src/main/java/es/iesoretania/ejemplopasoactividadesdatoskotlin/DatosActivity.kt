package es.iesoretania.ejemplopasoactividadesdatoskotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.iesoretania.ejemplopasoactividadesdatoskotlin.databinding.ActivityDatosBinding
import es.iesoretania.ejemplopasoactividadesdatoskotlin.databinding.ActivityMainBinding

class DatosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.TextViewNumero.textSize = 26F
        binding.TextViewText.textSize = 26F

        val bundle = intent.extras
        val numero = bundle?.getInt("numero")
        val texto = bundle?.getString("texto")

        binding.TextViewNumero.text = numero.toString()
        binding.TextViewText.text = texto

        binding.botonAtras.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}