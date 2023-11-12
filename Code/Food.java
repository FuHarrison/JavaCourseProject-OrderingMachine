public class Food {
        private int Id;
	private String Name;
	private int Price;
	private String Type;
	private String ImgPath;
	private int Quantity;
	public Food(String name,int price,String type, String path,int id){
                setName(name);
		setPrice(price);
		setType(type);
		setImgPath(path);
                setId(id);
	}
        
        public void setId(int id){
            Id = id;
        }
        public int getId(){
            return Id;
        }
	public void setQuantity(int a){
		Quantity=a;
	}
	public int getQuantity(){
		return Quantity;
	}
	public void setName(String name){
		Name = name;
	}
	public String getName(){
		return Name;
	}
	public void setPrice(int price){
		Price = price;
	}
	public int getPrice(){
		return Price;
	}
	public void setType(String type){
		Type = type;
	}
	public String getType(){
		return Type;
	}
	public void setImgPath(String path){
		ImgPath = path;
	}
	public String getImgPath(){
		return ImgPath;
	}
	public void incrementQuant(){
		Quantity++;
	}
	public void decrementQuant(){
		Quantity--;
	}
}