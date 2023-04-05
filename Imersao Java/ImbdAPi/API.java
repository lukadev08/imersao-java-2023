package ImbdAPi;

public enum API {
     
    IMBD_TOP_MOVIES("https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbmostpopularmovies.json", new ExtratorConteudoImbd()),    
    IMBD_TOP250_SERIES("https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbTop250TVs.json", new ExtratorConteudoImbd()),    
    IMBD_TOP250_MOVIES("https://raw.githubusercontent.com/lukadev08/lukadev08.github.io/main/apidata/imdbtop250moviesdata.json", new ExtratorConteudoImbd()),    
    NASA("https://api.nasa.gov/planetary/apod?api_key=YT0vezn1odIbbV6RapUl70UlO3ilvrUu0JJEFElH&start_date=2022-12-01&end_date=2022-12-10", new ExtratorConteudoNasa());

     private String url;
     private ExtratorDeConteudo extrator;

     
     public void setExtrator(ExtratorDeConteudo extrator) {
         this.extrator = extrator;
        }
        
        API(String url, ExtratorDeConteudo extrator){
            this.url = url;
            this.extrator = extrator;
        }
        
        public String getUrl(){
            return url;
        }
        
        public ExtratorDeConteudo getExtrator() {
           return extrator;
       }
}
