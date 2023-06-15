package com.example.test00_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_insert, btn_change, btn_add, btn1, btn2, btn3, btn4;

    ArrayList<MainDTO> dto = new ArrayList<>();

    TextView text_cost1, text_cnt1, text_cost2, text_cnt2, text_cost3, text_cnt3, text_cost4, text_cnt4;
    EditText edt_insert;
    int money;
    TextView change;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < CommonVal.names.length; i++) {
            dto.add(new MainDTO(CommonVal.names[i], CommonVal.price[i], CommonVal.cnt[i]));
        }


        btn_insert = findViewById(R.id.btn_insert);
        edt_insert = findViewById(R.id.edt_insert);
        btn_change = findViewById(R.id.btn_change);
        btn_add = findViewById(R.id.btn_add);
        change = findViewById(R.id.change);
        btn_insert.setOnClickListener(this);
        btn_change.setOnClickListener(this);

        text_cost1 = findViewById(R.id.text_cost1);
        text_cnt1 = findViewById(R.id.text_cnt1);
        btn1 = findViewById(R.id.btn1);
        text_cost2 = findViewById(R.id.text_cost2);
        text_cnt2 = findViewById(R.id.text_cnt2);
        btn2 = findViewById(R.id.btn2);
        text_cost3 = findViewById(R.id.text_cost3);
        text_cnt3 = findViewById(R.id.text_cnt3);
        btn3 = findViewById(R.id.btn3);
        text_cost4 = findViewById(R.id.text_cost4);
        text_cnt4 = findViewById(R.id.text_cnt4);
        btn4 = findViewById(R.id.btn4);


        btn1.setOnClickListener(this);
        text_cost1.setText(dto.get(0).getName() + dto.get(0).getCost() + "원");
        text_cnt1.setText(dto.get(0).getCnt() + "개 남음");
        btn2.setOnClickListener(this);
        text_cost2.setText(dto.get(1).getName() + dto.get(1).getCost() + "원");
        text_cnt2.setText(dto.get(1).getCnt() + "개 남음");
        btn3.setOnClickListener(this);
        text_cost3.setText(dto.get(2).getName() + dto.get(2).getCost() + "원");
        text_cnt3.setText(dto.get(2).getCnt() + "개 남음");
        btn4.setOnClickListener(this);
        text_cost4.setText(dto.get(3).getName() + dto.get(3).getCost() + "원");
        text_cnt4.setText(dto.get(3).getCnt() + "개 남음");


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CheckPassword.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_insert) {
            int[] arr = {100, 500, 1000, 5000, 10000};
            try {
                int addMoney = Integer.parseInt(edt_insert.getText().toString());
                int tempMoney = addMoney;
                int charge = addMoney;
                for (int i = 0; i < arr.length; i++) {
                    tempMoney = charge / arr[i];
                    charge = charge % arr[i];
                    if (charge == 0) {
                        break;
                    }
                }
                if (charge != 0) {
                    Toast.makeText(MainActivity.this, "반환됨. 금액을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else {
                    money += addMoney;
                    Toast.makeText(MainActivity.this, "금액 입력이 완료되었습니다." + money, Toast.LENGTH_SHORT).show();
                    change.setText("잔액 : " + money + "원");
                }
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "입력 오류. 숫자 값만 입력해주세요.", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.btn_change) {
            intent = new Intent(MainActivity.this, ResultActivity.class);
            Toast.makeText(MainActivity.this, money + "원 반환되었습니다.", Toast.LENGTH_SHORT).show();
            intent.putExtra("money", money);
            money = 0;
            change.setText("잔액 : " + money + "원");
            startActivity(intent);
        } else if (v.getId() == R.id.btn1) {
            if (dto.get(0).getCnt() > 0) {
                if (money >= (dto.get(0).getCost())) {
                    dto.set(0, new MainDTO(dto.get(0).getName(), dto.get(0).getCost(), dto.get(0).getCnt() - 1));
                    money -= dto.get(0).getCost();
                    text_cnt1.setText(dto.get(0).getCnt() + "개 남음");
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "다른 음료를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn2) {
            if (dto.get(1).getCnt() > 0) {
                if (money >= (dto.get(1).getCost())) {
                    dto.set(1, new MainDTO(dto.get(1).getName(), dto.get(1).getCost(), dto.get(1).getCnt() - 1));
                    money -= dto.get(1).getCost();
                    text_cnt2.setText(dto.get(1).getCnt() + "개 남음");
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "다른 음료를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn3) {
            if (dto.get(2).getCnt() > 0) {
                if (money >= (dto.get(2).getCost())) {
                    dto.set(2, new MainDTO(dto.get(2).getName(), dto.get(2).getCost(), dto.get(2).getCnt() - 1));
                    money -= dto.get(2).getCost();
                    text_cnt3.setText(dto.get(2).getCnt() + "개 남음");
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "다른 음료를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn4) {
            if (dto.get(3).getCnt() > 0) {
                if (money >= (dto.get(3).getCost())) {
                    dto.set(3, new MainDTO(dto.get(3).getName(), dto.get(3).getCost(), dto.get(3).getCnt() - 1));
                    money -= dto.get(3).getCost();
                    text_cnt4.setText(dto.get(3).getCnt() + "개 남음");
                } else {
                    Toast.makeText(this, "잔액이 부족합니다.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "다른 음료를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        }

    }

}