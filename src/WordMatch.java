public class WordMatch {
    private String word;

    public WordMatch(String word)
    {
        this.word = word;
    }

    public int scoreGuess(String guess)
    {
        int count = 0;
        if (guess.equals("")) {
            throw new IllegalArgumentException ("Your guess cannot be an empty String!");
        }
        if (guess.length() > word.length())
        {
            throw new IllegalArgumentException ("Your guess cannot exceed the number of characters in the Secret word");
        }
        for (int i = 0; i < word.length() - (guess.length()-1); i++)
        {
            if (guess.equals(word.substring(i,i+(guess.length()))))
            {
                count++;
            }
        }
        return count * guess.length() * guess.length();
    }

    public String findBetterGuess(String guess1, String guess2) {
        int count1 = scoreGuess(guess1);
        int count2 = scoreGuess(guess2);
        if (count1 > count2)
        {
            return guess1;
        }
        else if (count2 > count1)
        {
            return guess2;
        }
        else
        {
            if (guess1.compareTo(guess2) < 0) {
                return guess2;
            }
        }
        return guess1;
    }
}
