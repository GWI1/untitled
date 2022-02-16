package les1;

public class Member {
        private String name;
        private int distRun;
        private int distSwim;

        public Member(String name, int distRun, int distSwim) {
            this.name = name;
            this.distRun = distRun;
            this.distSwim = distSwim;


        }

        public String getName() {
            return name;
        }

        public int getDistRun() {
            return distRun;
        }
        public int getDistSwim() {
        return distSwim;
        }
}