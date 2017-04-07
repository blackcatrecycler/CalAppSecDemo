package top.recyclerblacat.calappdemp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private int FirstNum=0;
    private boolean Op=false;

    private View.OnClickListener NumListener=new View.OnClickListener() { //设置监听器
        @Override
        public void onClick(View view) {
            TextView t = (TextView) findViewById(R.id.Txt1);
            if(t.getText()=="0") t.setText("");
            switch (view.getId()){
                case R.id.Btn1:
                    t.setText(t.getText()+"1");
                    break;
                case R.id.Btn2:
                    t.setText(t.getText()+"2");
                    break;
                case R.id.Btn3:
                    t.setText(t.getText()+"3");
                    break;
                case R.id.Btn0:
                    t.setText(t.getText()+"0");
                    break;
            }
        }
    };

    private View.OnClickListener NumListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView t = (TextView) findViewById(R.id.Txt1);
            if(t.getText()=="0") t.setText("");
            Button bt = (Button) view;
            t.setText(t.getText()+bt.getText().toString());

        }
    };



    private void setButtonListener(int viewId){     //绑定监听器
        Button bt = (Button) findViewById(viewId);
        bt.setOnClickListener(NumListener2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取TextView Txt1，并将其置为0
        TextView t = (TextView) findViewById(R.id.Txt1);
        t.setText("0");

        //给按钮1230绑定监听器
        setButtonListener(R.id.Btn1);
        setButtonListener(R.id.Btn2);
        setButtonListener(R.id.Btn3);
        setButtonListener(R.id.Btn0);


    }

    //Btn1 '1' 点击事件
    public void  Btn1Click(View v){
        TextView t = (TextView) this.findViewById(R.id.Txt1);
        if(t.getText()=="0") t.setText("");
        t.setText(t.getText()+"0");
    }

    //加号 '+' 的点击事件
    public void  BtnAddClick(View v){
        Op=true;
        TextView t = (TextView) this.findViewById(R.id.Txt1);
        FirstNum = Integer.parseInt(t.getText().toString());
        t.setText("0");
    }

    //等号 '=' 的点击事件
    public void  BtnEqualClick(View v){
        if(Op){
            TextView t = (TextView) this.findViewById(R.id.Txt1);
            int nowInt = Integer.parseInt(t.getText().toString());
            nowInt= nowInt+ FirstNum;
            FirstNum=0;
            Op=false;
            String result = String.valueOf(nowInt);
            t.setText(result);
        }
    }
}
