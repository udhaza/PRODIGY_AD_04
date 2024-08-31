package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';
    private boolean gameActive = true;

    private TextView statusTextView;
    private Button resetButton;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);
        resetButton = findViewById(R.id.resetButton);
        gridLayout = findViewById(R.id.gridLayout);

        initializeBoard();

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            Button button = (Button) gridLayout.getChildAt(i);
            final int row = i / 3;
            final int col = i % 3;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (gameActive && board[row][col] == '\0') {
                        board[row][col] = currentPlayer;
                        button.setText(String.valueOf(currentPlayer));
                        if (checkWin()) {
                            statusTextView.setText("Player " + currentPlayer + " wins!");
                            gameActive = false;
                        } else if (isBoardFull()) {
                            statusTextView.setText("It's a draw!");
                            gameActive = false;
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            statusTextView.setText("Player " + currentPlayer + "'s turn");
                        }
                    }
                }
            });
        }

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '\0';
            }
        }
    }

    private boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)
            return true;
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0')
                    return false;
            }
        }
        return true;
    }

    private void resetGame() {
        initializeBoard();
        currentPlayer = 'X';
        gameActive = true;
        statusTextView.setText("Player X's turn");
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            Button button = (Button) gridLayout.getChildAt(i);
            button.setText("");
        }
    }
}