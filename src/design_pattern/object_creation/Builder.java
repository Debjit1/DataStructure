package design_pattern.object_creation;

class Emp {
    private int id;
    private String name;

    //create constructor to create object easily
    public Emp(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString(){
        return this.id + " "+name;
    }

    //create a static builder method to return builder
    public static EmpBuilder builder() {
        return new EmpBuilder();
    }

    //inner class must be static , so it's always static
    static class EmpBuilder {
        private int id;
        private String name;

        //always return builder so that we can add next parameter
        public EmpBuilder id(int id) {
            this.id = id;
            return this;
        }

        //always return builder so that we can add next parameter
        public EmpBuilder name(String name) {
            this.name = name;
            return this;
        }

        //create actual Emp object in this method
        public Emp build() {
            return new Emp(this.id, this.name);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Emp emp = Emp.builder().id(2).name("ABC").build();
        System.out.println(emp.toString());
    }
}
