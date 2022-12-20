package fr.azrotho.taverne.objects;

public class Players {
    private String id;
    private long xp;
    private int level;

    public Players(String id, long xp, int level) {
        this.id = id;
        this.xp = xp;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addXp(int xp){
        this.xp += xp;
    }

    public void addLevel(int level){
        this.level += level;
    }

    public void removeXp(int xp){
        this.xp -= xp;
    }

    public void removeLevel(int level){
        this.level -= level;
    }

    public void resetXp(){
        this.xp = 0;
    }

    public void resetLevel(){
        this.level = 0;
    }

    public void resetAll(){
        this.xp = 0;
        this.level = 0;
    }




}
