package geometrydash;

import java.util.Set;

public class GeometryDash {
    /**
     * Returns whether the given level can be completed using the given play.
     * @param level is not null and not empty
     * @param play is not null and not empty
     * @return true if the play completes the level and false otherwise
     */
    public static boolean isSuccessfulPlay(String level, String play) {
        if (level.charAt(0)=='^' || level.charAt(level.length()-1)=='^') {
            return false;
        }

        //boolean successful=false;
        int index=0;
        //int position=index+Integer.parseInt(String.valueOf(play.charAt(index)));
        int position=0;
        while (position<level.length()-1) {
            if (level.charAt(position+Integer.parseInt(String.valueOf(play.charAt(index))))!='_') {
                return false;
            } else {
                position+=Integer.parseInt(String.valueOf(play.charAt(index)));
                index++;
            }
            assert index<=play.length();
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
        // TODO: Implement this method
        return null;
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
        // TODO: Implement this method
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
