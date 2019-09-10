package thinhtien.pntt.phannguyentruongthinh.animalrace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbTiger, cbMickey, cbDog;
    SeekBar skTiger, skMickey, skDog;
    ImageButton ibtnPlay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        DisEnableSeekbar();

        txtDiem.setText(soDiem + "");

        Singlechoice();
        seekBarRandom();

    }

    private void EnableCheckBox(){
        cbTiger.setEnabled(true);
        cbMickey.setEnabled(true);
        cbDog.setEnabled(true);
    }

    private void DisEnableCheckBox(){
        cbTiger.setEnabled(false);
        cbMickey.setEnabled(false);
        cbDog.setEnabled(false);
    }

    private void DisEnableSeekbar(){
        skTiger.setEnabled(false);
        skMickey.setEnabled(false);
        skDog.setEnabled(false);
    }

    private void Singlechoice() {
        cbTiger.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbMickey.setChecked(false);
                    cbDog.setChecked(false);
                }
            }
        });
        cbMickey.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbTiger.setChecked(false);
                    cbDog.setChecked(false);
                }
            }
        });
        cbDog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cbTiger.setChecked(false);
                    cbMickey.setChecked(false);
                }
            }
        });
    }
    
    

    private void seekBarRandom() {
        final Random random = new Random();

        final CountDownTimer countDownTimer =  new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                if (skTiger.getProgress() >= skTiger.getMax()){
                    Toast.makeText(MainActivity.this, skTiger.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //kiểm tra đặt cược
                    if(cbTiger.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if (skMickey.getProgress() >= skMickey.getMax()){
                    Toast.makeText(MainActivity.this, skMickey.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //kiểm tra đặt cược
                    if(cbMickey.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if (skDog.getProgress() >= skDog.getMax()){
                    Toast.makeText(MainActivity.this, skDog.getTag().toString(), Toast.LENGTH_SHORT).show();
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    //kiểm tra đặt cược
                    if(cbDog.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                int number = 5;
                int tiger = random.nextInt(number);
                int mickey = random.nextInt(number);
                int dog = random.nextInt(number);
                skTiger.setProgress(skTiger.getProgress() + tiger);
                skMickey.setProgress(skMickey.getProgress() + mickey);
                skDog.setProgress(skDog.getProgress() + dog);
            }

            @Override
            public void onFinish() {

            }
        };

        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // kiểm tra đã check chưa mới dc chạy
                if(cbTiger.isChecked() || cbMickey.isChecked() || cbDog.isChecked()){
                    skTiger.setProgress(0);
                    skMickey.setProgress(0);
                    skDog.setProgress(0);

                    ibtnPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisEnableCheckBox();
                }
                Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void AnhXa(){
        txtDiem     = findViewById(R.id.textviewDiemso);
        ibtnPlay    = findViewById(R.id.buttonPlay);
        cbTiger     = findViewById(R.id.checkboxTiger);
        cbMickey    = findViewById(R.id.checkboxMickey);
        cbDog       = findViewById(R.id.checkboxDog);
        skTiger     = findViewById(R.id.seekbarTiger);
        skTiger.setTag("Tiger");
        skMickey    = findViewById(R.id.seekbarMickey);
        skMickey.setTag("Mickey");
        skDog       = findViewById(R.id.seekbarDog);
        skDog.setTag("Dog");
    }
}
