package christmas.models;

public enum Badge {

    STAR("별"), TREE("트리"), SANTA("산타"), NONE("없음");

    Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static Badge of(int eventPrice) {
        if (eventPrice >= 20000) {
            return Badge.SANTA;
        }
        if (eventPrice >= 10000) {
            return Badge.TREE;
        }
        if (eventPrice >= 5000) {
            return Badge.STAR;
        }
        return Badge.NONE;
    }

    final String badgeName;
}
