// Code for adding buttons
// place this code in loadtheflag() method . This method is
// ADDING BUTTONS AND SETTING TEXT ON OPTIONS
// RANDOMLY SELECT ONE BUTTON FOR CORRECT ANSWER

//TODO 14) Add buttons in your view
        // put the correct answer at the end of fileNameList
        int correct = fileNameList.indexOf(correctAnswer);
        fileNameList.add(fileNameList.remove(correct));
        // add 2, 4, 6 or 8 guess Buttons based on the value of guessRows
        for (int row = 0; row < guessRows; row++) {
            // place Buttons in currentTableRow
            for (int column = 0;
                 column < guessLinearLayouts[row].getChildCount();
                 column++) {
                // get reference to Button to configure
                Button newGuessButton =
                        (Button) guessLinearLayouts[row].getChildAt(column);
                newGuessButton.setEnabled(true);

                // get country name and set it as newGuessButton's text
                String filename = fileNameList.get((row * 2) + column);
                newGuessButton.setText(getCountryName(filename));
            }
        }
        // randomly replace one Button with the correct answer
        int row = random.nextInt(guessRows); // pick random row
        int column = random.nextInt(2); // pick random column
        LinearLayout randomRow = guessLinearLayouts[row]; // get the row
        String countryName = getCountryName(correctAnswer);
        ((Button) randomRow.getChildAt(column)).setText(countryName);
        
-----------------------------------------------------------------------------------------------------------------------
//PLACE THIS CODE IN ONCREATEVIEW()
//TODO 15) Add the listeneer for all buttons
        // configure listeners for the guess Buttons
        for (LinearLayout row : guessLinearLayouts) {
            for (int column = 0; column < row.getChildCount(); column++) {
                Button button = (Button) row.getChildAt(column);
                button.setOnClickListener(guessButtonListener);
            }
        }
---------------------------------------------------------------------------------------------------------------------------
//CREATE A NEW METHOD FOR LISTENER
//TODO 16) Add code in the OnClick() 
         private View.OnClickListener guessButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button guessButton = ((Button) v);
            String guess = ((Button) v).getText().toString();
            String answer = getCountryName(correctAnswer);

            //if the guess is correct
            // display correct answer in green text
            if(guess.equals(answer))
            {
                count++;
                answerTextView.setText(answer + "!");
         //set the text in green Color
                disableAllButtons();
            }
            else
            {
              //  flagImageView.startAnimation(shakeAnimation); // play shake

                // display "Incorrect!" in red
                answerTextView.setText(R.string.incorrect_answer);
              //set the text in red Color
                guessButton.setEnabled(false); // disable incorrect answer
            }

        }
        };

    // utility method that disables all answer Buttons
        public void disableAllButtons()
        {
            for(int row=0;row<guessRows;row++)
            {
                LinearLayout guessRow = guessLinearLayouts[row];
                for(int i=0;i<guessRow.getChildCount();i++)
                {
                    guessRow.getChildAt(i).setEnabled(false);
                }
            }
        }
      
