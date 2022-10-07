package geometrydash;

import java.util.HashSet;
import java.util.Set;

public class GeometryDash {
    /**
     * Returns whether the given level can be completed using the given play.
     * @param level is not null and not empty
     * @param play is not null and not empty
     * @return true if the play completes the level and false otherwise
     */
    public static boolean isSuccessfulPlay(String level, String play) {
        if (!validLevel(level)) {
            return false;
        }

        int index=0;
        int position=0;

        while (position<level.length()-1) {

            if (level.charAt(position+Integer.parseInt(String.valueOf(play.charAt(index))))=='^') {
                return false;
            } else {
                position+=Integer.parseInt(String.valueOf(play.charAt(index)));
                index++;
            }

            if (position>level.length()-1) {
                return false;
            }

            assert index<=play.length();
        }

        return true;
    }

    private static boolean isSuccessfulPlay(String level, String play, int eStart, int eRest) {
        int index=0;
        int position=0;
        int e=eStart;

        while (index<play.length()) {

            if (position+Integer.parseInt(String.valueOf(play.charAt(index)))>=level.length()) {
                return false;
            }

            if (level.charAt(position+Integer.parseInt(String.valueOf(play.charAt(index))))=='^') {
                return false;
            } else {
                e-=Integer.parseInt(String.valueOf(play.charAt(index)));
                if (e<0) {
                    return false;
                } else if (Integer.parseInt(String.valueOf(play.charAt(index)))==0 && e<3) {
                    e++;
                }

                if(level.charAt(position+Integer.parseInt(String.valueOf(play.charAt(index))))=='*'){
                    position+=Integer.parseInt(String.valueOf(play.charAt(index)));
                    position+=4;
                } else {
                    position+=Integer.parseInt(String.valueOf(play.charAt(index)));
                }
                index++;
            }

            if (position>level.length()) {
                return false;
            }
        }

        if (e<eRest) {
            return false;
        }
        return true;
    }

    /**
     * Returns the subset of plays which can complete the given level ending
     * with the target resting energy
     * @param level is not null and not empty
     * @param possiblePlays is not null
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return a subset of {@code possiblePlays} which complete the level with
     * {@code targetRestingEnergy} units of energy remaining
     */
    public static Set<String> successfulPlays(String level, Set<String> possiblePlays,
                                              int startingEnergy, int targetRestingEnergy) {
        Set<String> successful=new HashSet<>();

        if (!validLevel(level)) {
            return successful;
        }

        for (String s: possiblePlays.toArray(new String[0])) {
            if (isSuccessfulPlay(level,s,startingEnergy,targetRestingEnergy)){
                successful.add(s);
            }
        }

        return successful;
    }

    private static boolean validLevel(String level) {
        if (level.charAt(0)=='^' || level.charAt(level.length()-1)=='^') {
            return false;
        }
        return true;
    }

    /**
     * Returns the shortest play that completes the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the shortest play that allows a player to complete the given level
     * @throws UnplayableLevelException if no play can complete the level
     */
    public static String shortestPlay(String level, int startingEnergy, int targetRestingEnergy)
            throws UnplayableLevelException {
        if (!validLevel(level)) {
            throw new UnplayableLevelException();
        }


        return null;
    }

    /**
     * Returns the total number of plays which allow a player to complete the given level
     * @param level is not null and not empty
     * @param startingEnergy the energy at the start of the level
     * @param targetRestingEnergy the minimum energy to end the level at
     * @return the total number of plays which allow a player to complete the given level
     * with target resting energy {@code targetRestingEnergy}
     */
    public static int numberOfPlays(String level, int startingEnergy, int targetRestingEnergy) {
        // TODO: Implement this method
        return -1;
    }
}
