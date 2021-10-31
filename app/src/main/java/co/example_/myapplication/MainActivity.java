package co.example_.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    int before = 100;//이전버튼을 누룬 것의 저장징소
    int touchX,touchY;
    int flag=0;

    int[] fistWrong = new int[]{0,0};
    int[] secondWrong = new int[]{0,0};
    int checkInt=0;
    int[][] grid= new int[][]
            {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
    Button button[] = new Button[81];
    Integer[] btnID={
            R.id.a_1, R.id.b_1, R.id.c_1, R.id.d_1, R.id.e_1,
            R.id.f_1, R.id.h_1, R.id.i_1, R.id.j_1,

            R.id.a_2, R.id.b_2, R.id.c_2, R.id.d_2, R.id.e_2,
            R.id.f_2, R.id.h_2, R.id.i_2, R.id.j_2,

            R.id.a_3, R.id.b_3, R.id.c_3, R.id.d_3, R.id.e_3,
            R.id.f_3, R.id.h_3, R.id.i_3, R.id.j_3,

            R.id.a_4, R.id.b_4, R.id.c_4, R.id.d_4, R.id.e_4,
            R.id.f_4, R.id.h_4, R.id.i_4, R.id.j_4,

            R.id.a_5, R.id.b_5, R.id.c_5, R.id.d_5, R.id.e_5,
            R.id.f_5, R.id.h_5, R.id.i_5, R.id.j_5,

            R.id.a_6, R.id.b_6, R.id.c_6, R.id.d_6, R.id.e_6,
            R.id.f_6, R.id.h_6, R.id.i_6, R.id.j_6,

            R.id.a_7, R.id.b_7, R.id.c_7, R.id.d_7, R.id.e_7,
            R.id.f_7, R.id.h_7, R.id.i_7, R.id.j_7,

            R.id.a_8, R.id.b_8, R.id.c_8, R.id.d_8, R.id.e_8,
            R.id.f_8, R.id.h_8, R.id.i_8, R.id.j_8,

            R.id.a_9, R.id.b_9, R.id.c_9, R.id.d_9, R.id.e_9,
            R.id.f_9, R.id.h_9, R.id.i_9, R.id.j_9
    };
    Button numberBtn[] = new Button[9];
    Integer[] numberID={
            R.id.one, R.id.two, R.id.three, R.id.four, R.id.five,
            R.id.six, R.id.seven, R.id.eight, R.id.nine
    };

    Button Reset,Answer,Cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Reset = findViewById(R.id.reset);
        Answer = findViewById(R.id.answer);
        Cancel = findViewById(R.id.cancel);

        for(int i=0;i<81;i++){
            button[i]=(Button)findViewById(btnID[i]);
        }

        for(int i=0;i<9;i++){
            System.out.println(i);
            numberBtn[i]=(Button)findViewById(numberID[i]);
        }

        for(int i=0; i<button.length; i++){
            final int INDEX;
            INDEX = i;



            button[INDEX].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(flag==1){
                        Toast.makeText(getApplicationContext(), "리셋 후 사용해 주세요.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(before!=100){
                        button[before].setBackgroundColor(Color.WHITE);
                    }
                    before=INDEX;
                    button[INDEX].setBackgroundColor(Color.GRAY);


                }
            });
        }

        for(int i=0; i<numberBtn.length; i++){
            final int INDEX;
            INDEX = i;

            numberBtn[INDEX].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if(flag==1){
                        Toast.makeText(getApplicationContext(), "리셋 후 사용해 주세요.", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(before!=100){

                        button[before].setTextColor(Color.parseColor("#ff0000"));
                        button[before].setText(INDEX+1+"");

                        touchX=before%9;
                        touchY=((8-touchX)+before)/10;

                        grid[touchY][touchX]=INDEX+1;
                        System.out.println(touchX+" "+touchY);
                        System.out.println(grid[touchX][touchY]);

                    }
                }
            });
        }

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a,b;
                before=100;
                for(int i=0;i<81;i++){
                    button[i].setBackgroundColor(Color.WHITE);
                    button[i].setText("");
                    button[i].setTextColor(Color.parseColor("#000000"));
                }

                flag=0;

                for (a = 0; a < 9; a++)
                {
                    for (b = 0; b < 9; b++)
                    {
                        grid[a][b]=0;
                        System.out.print( grid[b][a]);

                    }
                    System.out.println();
                }
            }
        });

        Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a,b;
                int wrong1;
                int wrong2;
                if(flag==1){
                    Toast.makeText(getApplicationContext(), "리셋 후 사용해 주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(check(grid)){
                    solve(grid);
                    for(int i=0;i<81;i++)
                    {
                        button[i].setBackgroundColor(Color.WHITE);
                        a=i%9;
                        b=((8-a)+i)/10;
                        button[i].setText(grid[b][a]+"");

                    }

                }else{
                    wrong1=(9*fistWrong[1])+fistWrong[0];
                    wrong2=(9*secondWrong[1])+secondWrong[0];
                    button[wrong1].setTextColor(Color.BLUE);
                    button[wrong2].setTextColor(Color.BLUE);
                    System.out.println("여가 왔다");
                }

            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1){
                    Toast.makeText(getApplicationContext(), "리셋 후 사용해 주세요.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(before!=100){
                    button[before].setText("");
                    button[before].setTextColor(Color.parseColor("#000000"));
                    touchX=before%9;
                    touchY=((8-touchX)+before)/10;
                    grid[touchY][touchX]=0;


                }
            }
        });
    }
    public void solve(int grid[][]){
        int x, y, n;
        for (y = 0; y < 9; y++)
        {
            for (x = 0; x < 9; x++)
            {
                if (grid[y][x] == 0)
                {
                    for (n = 1; n < 10; n++)
                    {
                        if (possible(y, x, n, grid))
                        {
                            grid[y][x] = n;
                            solve(grid);
                            if (flag==1)
                            {
                                return;
                            }

                            grid[y][x] = 0;
                        }
                    }

                    return;
                }
            }
        }

        int a, b;
        for (a = 0; a < 9; a++)
        {
            for (b = 0; b < 9; b++)
            {
                System.out.print( grid[a][b]);
            }
            System.out.println();
        }
        flag = 1;
    }

    public boolean possible(int y, int x,int n,int grid[][])
    {
        int i, j, x0, y0;
        for (i = 0; i < 9; i++)
        {
            if(x==i && checkInt==1){
                i++;
                if(i==9)
                    break;
            }
            if (grid[y][i] == n){
                secondWrong[0]=i;
                secondWrong[1]=y;

                return false;
            }

        }
        for (i = 0; i < 9; i++)
        {
            if(y==i && checkInt==1){
                i++;
                if(i==9)
                    break;
            }
            if (grid[i][x] == n){
                secondWrong[0]=x;
                secondWrong[1]=i;

                return false;
            }
        }

        x0 = (x / 3) * 3;
        y0 = (y / 3) * 3;

        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 3; j++)
            {

                if(y0+i==y && x0+j==x && checkInt==1){
                    if(i==2){
                        if(j==2)
                            break;
                        j++;
                    }else{
                        i++;
                    }
                }
                if (grid[y0 + i][x0 + j] == n){
                    secondWrong[0]=x0 + j;
                    secondWrong[1]=y0 + i;
                    return false;
                }
            }
        }
        checkInt=0;
        return true;
    }
    public boolean check(int grid[][]){
        int a,b;
        for(a=0;a<9;a++)
        {
            for(b=0;b<9;b++)
            {
                if(grid[a][b]!=0)
                {
                    checkInt=1;
                    if(possible(a,b,grid[a][b],grid))
                    {
                        System.out.println("성공");

                    }else{
                        System.out.println(b+" "+a);
                        fistWrong[0] = b;
                        fistWrong[1] = a;
                        Toast.makeText(getApplicationContext(), "파란색 숫자가 잘못된 입력이 있습니다.", Toast.LENGTH_LONG).show();
                        return false;
                    }
                }

            }
        }
        return true;

    }
}