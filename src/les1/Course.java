package les1;

public class Course {
    String result;
    private int sprint;
    private int pool;



    public Course(int sprint, int pool) {
        this.sprint = sprint;
        this.pool = pool;
    }

    public String c (Team team){
        result = "Team "+ team.getName()+ " " + '\n';
        for(Member member: team.getMembers()){
            result += "Name: " + member.getName()+ " " + '\n';
            int valueRun = member.getDistRun();
            int valueSwim = member.getDistSwim();
            testRun(valueRun);
            testSwim(valueSwim);
        }
        return result;
    }

    private void testRun(int valueRun){
        if(valueRun>=sprint) result += "run the distance "+ '\n';

    }

    private void testSwim(int valueSwim){
        if(valueSwim>=pool) result += "swam the distance "+ '\n';

    }
}
