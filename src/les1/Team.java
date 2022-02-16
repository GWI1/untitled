package les1;

public class Team {
    private String name;
    private Member[] members;

    public Team(String name, Member[] members) {
        this.name = name;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public Member[] getMembers() {
        return members;
    }
}
