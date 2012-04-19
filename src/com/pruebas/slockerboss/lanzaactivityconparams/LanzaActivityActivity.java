package com.pruebas.slockerboss.lanzaactivityconparams;



import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LanzaActivityActivity extends Activity {

	private static final int REQUEST_CODE_ABOUT_YOU = 1;
	private static final int REQUEST_CODE_BROWSER = 2;

	protected Intent intento;

	private String param1Nombre, param2Url;

	private EditText editTextParam1Nombre, editTextParam2Url;
	private TextView textViewInfoAboutYou;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);

		editTextParam1Nombre = (EditText) findViewById(R.id.EditTextParam1Nombre);
		editTextParam2Url = (EditText) findViewById(R.id.EditTextParam2Url);
	}

	public void llamarIntent(View v) {
		int queBoton = v.getId();
		switch (queBoton) {
		case R.id.BotonLanzarActividad3:
			param1Nombre = editTextParam1Nombre.getText().toString();

			if (param1Nombre.equals("")) {
				param1Nombre = "Perico el de los Palotes";
			}

			intento = new Intent(this, AboutYou.class);
			intento.putExtra("nombre", param1Nombre);
			startActivityForResult(intento, REQUEST_CODE_ABOUT_YOU);

			break;

		case R.id.BotonLanzarActividad4:

			param2Url = editTextParam2Url.getText().toString();
			if (param2Url.equals("")) {

				param2Url = "www.slockerboss.nixiweb.com";
			}
			intento = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"
					+ param2Url));
			startActivity(intento);
			break;

		default:
			this.setContentView(R.layout.main);
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case REQUEST_CODE_ABOUT_YOU:
			// when returns from AboutYou CODE
			textViewInfoAboutYou = (TextView) findViewById(R.id.TextViewInformativoAboutYou);
			if (resultCode == android.app.Activity.RESULT_OK) {

				if (data.hasExtra("nombreRetorno")) {
					Bundle extras = data.getExtras();
					String nombreRetorno = extras.getString("nombreRetorno");
					textViewInfoAboutYou.append("Has vuelto con Exito "
							+ nombreRetorno + "\n");

					Toast.makeText(this,
							data.getExtras().getString("nombreRetorno"),
							Toast.LENGTH_SHORT).show();

				}

			} else {
				textViewInfoAboutYou
						.append("Error! La prox pulsa en finalizar\n");
			}

			break;
		case REQUEST_CODE_BROWSER:
			// when returns from Browser CODE
			break;

		default:
			break;
		}

	}
}