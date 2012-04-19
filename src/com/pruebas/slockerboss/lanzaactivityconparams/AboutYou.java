package com.pruebas.slockerboss.lanzaactivityconparams;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AboutYou extends Activity {

	private Button botonFinalizar;
	private TextView textViewParam1;
	String nombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.aboutyou);

		nombre = getIntent().getExtras().getString("nombre");
		

		if (nombre != null) {
			textViewParam1 = (TextView) findViewById(R.id.TextViewParamNombre);
			textViewParam1.append(nombre);

		} else
			{textViewParam1.append("Vacio");}

		botonFinalizar = (Button) findViewById(R.id.BotonFinalizar);
		botonFinalizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finalizarActividad(AboutYou.this);
			}
		});
	}

	protected void finalizarActividad(AboutYou aboutMe) {

		
		
		Intent volver = new Intent();
		volver.putExtra("nombreRetorno", nombre);
		setResult(android.app.Activity.RESULT_OK, volver);
		this.finish();
		
		

	}

}
