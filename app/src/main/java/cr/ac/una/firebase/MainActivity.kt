package cr.ac.una.firebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var personasRef: DatabaseReference
    private lateinit var texto: EditText
    private lateinit var boton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.cajaTexto)
        boton = findViewById(R.id.boton)

        // Inicializar Firebase
        FirebaseApp.initializeApp(this)

        // Obtener referencia a la base de datos "personas"
        val database = FirebaseDatabase.getInstance()
        personasRef = database.getReference("persona")

        boton.setOnClickListener {
            val persona = Persona(texto.text.toString())
            val personaId = personasRef.push().key
            personasRef.child(personaId!!).setValue(persona)
        }


    }
}