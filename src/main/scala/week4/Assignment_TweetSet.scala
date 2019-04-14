package week4


abstract class TweetSet {

  var retweet:Int = 0
  def contains(tweet: String): Boolean

  def incl(tweet: String): TweetSet

  override def toString: String = ""
}

class Empty extends TweetSet {

  retweet = 0

  def contains(tweet: String): Boolean = false

  def incl(tweet: String): TweetSet = new NonEmpty(tweet, new Empty, new Empty)

  override def toString: String = "."
}

class NonEmpty(tweet: String, left: TweetSet, right: TweetSet) extends TweetSet {

  def reTweet(count:Int) = {
    retweet =count
  }
  override def contains(searchTweet: String): Boolean = {
    if (searchTweet < tweet) left contains searchTweet
    else if (searchTweet > tweet) right contains searchTweet
    else true
  }

  override def incl(searchTweet: String): TweetSet = {
    if (searchTweet < tweet) new NonEmpty(tweet, left incl searchTweet, right)
    else if (searchTweet > tweet) new NonEmpty(tweet, left, right incl searchTweet)
    else this
  }

  override def toString: String = "{" + left + " " + tweet + " "+ right + "}"

  def filter(f: TweetSet => Boolean)={

  }
}

object Assignment_TweetSet extends App {

  val t1 = new NonEmpty("A", new Empty, new Empty)
  val t2 = t1 incl ("B")
  println(t2)

}
