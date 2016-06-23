package cn.edu.fzu.sm.jsq;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText textResult;
	private Button[] btnNum = new Button[10];
	private Button btnDot, btnNeg;
	private Button btnAdd, btnMinus, btnMultiply, btnDivide, btnEqual;
	private Button btnBC, btnC, btnCE;

	private String strOpp1 = "", strOpp2 = "";
	private int intOppType = 0;
	private float floatResult = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textResult = (EditText) findViewById(R.id.editTextResult);
		textResult.setText("0");

		btnNum[0] = (Button) findViewById(R.id.button0);
		btnNum[1] = (Button) findViewById(R.id.button1);
		btnNum[2] = (Button) findViewById(R.id.button2);
		btnNum[3] = (Button) findViewById(R.id.button3);
		btnNum[4] = (Button) findViewById(R.id.button4);
		btnNum[5] = (Button) findViewById(R.id.button5);
		btnNum[6] = (Button) findViewById(R.id.button6);
		btnNum[7] = (Button) findViewById(R.id.button7);
		btnNum[8] = (Button) findViewById(R.id.button8);
		btnNum[9] = (Button) findViewById(R.id.button9);

		btnDot = (Button) findViewById(R.id.buttonDot);
		btnNeg = (Button) findViewById(R.id.buttonNeg);

		btnAdd = (Button) findViewById(R.id.buttonAdd);
		btnMinus = (Button) findViewById(R.id.buttonMinus);
		btnMultiply = (Button) findViewById(R.id.buttonMultiply);
		btnDivide = (Button) findViewById(R.id.buttonDivide);
		btnEqual = (Button) findViewById(R.id.buttonEqual);

		btnBC = (Button) findViewById(R.id.buttonBC);
		btnC = (Button) findViewById(R.id.buttonC);
		btnCE = (Button) findViewById(R.id.buttonCE);

		btnNum[0].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "0";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "0";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[1].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "1";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "1";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[2].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "2";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "2";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[3].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "3";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "3";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[4].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "4";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "4";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[5].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "5";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "5";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[6].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "6";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "6";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[7].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "7";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "7";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[8].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "8";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "8";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNum[9].setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + "9";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + "9";
					textResult.setText(strOpp2);
				}
			}
		});

		btnDot.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = strOpp1 + ".";
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = strOpp2 + ".";
					textResult.setText(strOpp2);
				}
			}
		});

		btnNeg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					if (strOpp1 == "") {
						textResult.setText("0");
					} else {
						strOpp1 = String.valueOf(-Float.parseFloat(strOpp1));
						textResult.setText(strOpp1);
					}
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					if (strOpp2 == "") {
						textResult.setText("0");
					} else {
						strOpp2 = String.valueOf(-Float.parseFloat(strOpp2));
						textResult.setText(strOpp2);
					}
				}
			}
		});

		btnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intOppType = 1;
			}
		});

		btnMinus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intOppType = 2;
			}
		});

		btnMultiply.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intOppType = 3;
			}
		});

		btnDivide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intOppType = 4;
			}
		});

		btnCE.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					strOpp1 = "0";
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					strOpp2 = "0";
				}
				textResult.setText("0");
			}
		});

		btnC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				strOpp1 = "";
				strOpp2 = "";
				intOppType = 0;
				floatResult = 0;
				textResult.setText("0");
			}
		});

		btnBC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (intOppType == 0) {
					if (strOpp1.length() > 0) {
						strOpp1 = strOpp1.substring(0, strOpp1.length() - 1);
					} else {
						strOpp1 = "0";
					}
					textResult.setText(strOpp1);
				} else if (intOppType == 1 || intOppType == 2
						|| intOppType == 3 || intOppType == 4) {
					if (strOpp1.length() > 0) {
						strOpp2 = strOpp2.substring(0, strOpp2.length() - 1);
					} else {
						strOpp2 = "0";
					}
					textResult.setText(strOpp2);
				}
			}
		});

		btnEqual.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (strOpp1 == "") {
					strOpp1 = "0";
				}
				if (strOpp2 == "") {
					strOpp2 = "0";
				}
				if (intOppType == 1) { // add
					floatResult = Float.parseFloat(strOpp1)
							+ Float.parseFloat(strOpp2);
					textResult.setText("" + floatResult);
				} else if (intOppType == 2) { // minus
					floatResult = Float.parseFloat(strOpp1)
							- Float.parseFloat(strOpp2);
					textResult.setText("" + floatResult);
				} else if (intOppType == 3) { // multiply
					floatResult = Float.parseFloat(strOpp1)
							* Float.parseFloat(strOpp2);
					textResult.setText("" + floatResult);
				} else if (intOppType == 4) { // divide
					if (strOpp2 == "0") {
						textResult.setText("除数不能为零");
						return;
					} else {
						floatResult = Float.parseFloat(strOpp1)
								/ Float.parseFloat(strOpp2);
						textResult.setText("" + floatResult);
					}
				}
				strOpp1 = textResult.getText().toString();
				strOpp2 = "";
				intOppType = 0;
			}
		});
	}
}
