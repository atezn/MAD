class Song(val title: String, val artist: String, val year_published: Int, val play_count: Int){
    val is_popular: Boolean
    	get() = play_count >= 1000
    
    fun print_description(){
        println("$title, $artist, year:$year_published, times played:$play_count")
    }
}

fun main() {
    var song = Song("song", "artist", 1999, 500);
    
    song.print_description();
}

