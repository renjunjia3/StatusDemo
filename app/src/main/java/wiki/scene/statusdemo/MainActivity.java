package wiki.scene.statusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wiki.scene.statuslib.StatusViewLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private StatusViewLayout statusViewLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    statusViewLayout = (StatusViewLayout) findViewById(R.id.statusViewLayout);
    statusViewLayout.showLoading();


    findViewById(R.id.btn_content).setOnClickListener(this);
    findViewById(R.id.btn_loading).setOnClickListener(this);
    findViewById(R.id.btn_empty).setOnClickListener(this);
    findViewById(R.id.btn_fail).setOnClickListener(this);
    findViewById(R.id.btn_noNetwork).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_content:
        statusViewLayout.showContent();
        break;
      case R.id.btn_loading:
        statusViewLayout.showLoading();
        break;
      case R.id.btn_fail:
        statusViewLayout.showFailed(retryListener);
        break;
      case R.id.btn_noNetwork:
        statusViewLayout.showNetError(retryListener);
        break;
      case R.id.btn_empty:
        statusViewLayout.showNone(retryListener);
        break;
    }
  }

  private View.OnClickListener retryListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      MainActivity.this.statusViewLayout.showLoading();
    }
  };
}
