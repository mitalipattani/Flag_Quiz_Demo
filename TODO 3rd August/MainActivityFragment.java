   
   //Declare a class variable total Guess;
    public static int totalGuess=0;
    
    //calcuate the guess and if count=10 than display the result dialog
  if(guess.equals(answer))
            {
                count++;
                answerTextView.setText(answer + "!");
                answerTextView.setTextColor(
                        getResources().getColor(R.color.correct_answer,
                                getContext().getTheme()));
                disableAllButtons();
                // load the next flag after a 2-second delay
                if(count<=10) {
                    handler.postDelayed(
                            new Runnable() {
                                @Override
                                public void run() {
                                    loadtheflag(); // animate the flag off the screen
                                }
                            }, 2000); // 2000 milliseconds for 2-second delay
                }
                else
                {
                    ResultDialog dialog = new ResultDialog(); //creates a result alert dialog
                    dialog.show(getFragmentManager(),"Notice");
                }
            }
            else
            {
                //Animate (Shake) for Flag Image
                flagImageView.startAnimation(shakeAnimation);

                // display "Incorrect!" in red
                answerTextView.setText(R.string.incorrect_answer);
                answerTextView.setTextColor(getResources().getColor(
                        R.color.incorrect_answer, getContext().getTheme()));
                guessButton.setEnabled(false); // disable incorrect answer
            }

        }
        };
