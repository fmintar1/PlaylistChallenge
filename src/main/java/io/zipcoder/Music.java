package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        if(playList[startIndex] == selection) {
            return 0;
        }
        int counterForward = counterForward(startIndex, selection);
        int counterBackward = counterBackward(startIndex, selection);
        if(counterForward < counterBackward) {
            return counterForward;
        }
        return counterBackward;
    }

    public int counterForward(Integer startIndex, String selection) {
        int counterForward = 0;
        int i = startIndex;
        while(playList[i] != selection) {
            if(playList[i] == selection) {
                break;
            }
            i++;
            counterForward++;
            i = i % playList.length;
        }
        return counterForward;
    }

    public int counterBackward(Integer startIndex, String selection) {
        int counterBackward = 0;
        int i = startIndex;
        while(playList[i] != selection) {
            if(playList[i] == selection) {
                break;
            }
            i--;
            counterBackward++;
            if(i < 0) {
                i = (playList.length-1);
            }
        }
        return counterBackward;
    }
}
